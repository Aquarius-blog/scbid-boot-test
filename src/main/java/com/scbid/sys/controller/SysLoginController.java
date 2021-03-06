package com.scbid.sys.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.scbid.common.shiro.ShiroUtils;
import com.scbid.common.utils.R;
import com.scbid.sys.entity.BondUserEntity;
import com.scbid.sys.service.BondUserService;

/**
 * 登录相关
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@Controller
public class SysLoginController {
	@Autowired
	private Producer producer;

	@Autowired
	private BondUserService bondUserService;

	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到shiro session
		ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}

	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/login", method = {RequestMethod.POST, RequestMethod.GET})
	public R login(String username, String password, String captcha) {
		
		if (StringUtils.isEmpty(username)) {
			return R.error("账号不能为空");
		}
		if (StringUtils.isEmpty(password)) {
			return R.error("密码不能为空");
		}
		if (StringUtils.isEmpty(captcha)) {
			return R.error("验证码不能为空");
		}
		BondUserEntity bondUserMode = bondUserService.queryByLoginNo(username);
		if (bondUserMode==null) {
			return R.error("输入账号不存在");
		}
		
//		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		
//		if (!kaptcha.equals(captcha)) {
//			return R.error("验证码不正确");
//		}
		try {
			Subject subject = ShiroUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
		} catch (UnknownAccountException e) {
			return R.error("登录账号未知");
		} catch (IncorrectCredentialsException e) {
			return R.error("账号或密码不正确");
		} catch (LockedAccountException e) {
			return R.error("账号已被锁定,请联系管理员解除锁定");
		} catch (ExcessiveAttemptsException eae) {
			return R.error("尝试认证次数多余系统指定次数");
		} catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}

		return R.ok().put("bondUserMode", bondUserMode);
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "logout", method = {RequestMethod.POST, RequestMethod.GET})
	public String logout() {
		ShiroUtils.logout();
		return "redirect:home.html";
	}

}
