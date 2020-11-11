package com.scbid.common.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.ServiceException;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

/**
 * @Title: BLSimpleOSS.java
 * @Description: 简单OSS类
 * @Package com.bloom.common.core.aliyunOSS
 * @Author: 米雪铭
 * @Date: 2016年12月12日 下午2:12:13
 * @Copyright: 成都必朗科技有限公司 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class AliyunOSSUtils {

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(AliyunOSSUtils.class);
	/** 过期时间 */
	private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24 * 365 * 100;
	public static final String CONSTANT_COMMON_SPOT = ".";
	private static AliyunOssConfig aliyunOssConfig;

	public AliyunOSSUtils() {

	}

	public AliyunOSSUtils(AliyunOssConfig ossConfig) {
		try {
			aliyunOssConfig = ossConfig;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: openOssClient
	 * @Description: 获取OSS存储对象
	 * @author: 李星江
	 * @date: 2017年1月3日 下午8:39:14
	 * @return
	 */
	public static OSSClient openOssClient() {
		String endpoint = aliyunOssConfig.getEndpoint();
		OSSClient ossClient = new OSSClient(aliyunOssConfig.getEndpoint(), aliyunOssConfig.getAccessKey(), aliyunOssConfig.getAccessSecret());
		try {
			boolean exists = ossClient.doesBucketExist(aliyunOssConfig.getBucket());
			if (!exists) {
				logger.error("bucket不存在，新建当前bucket:{}", aliyunOssConfig.getBucket());
				ossClient.createBucket(aliyunOssConfig.getBucket());
			}
		} catch (ServiceException e) {
			logger.error(e.getErrorCode() + "  " + e.getErrorMessage());
			throw e;
		}
		return ossClient;
	}

	/**
	 * 上传文件到OSS服务器 如果同名文件会覆盖服务器上的
	 *
	 * @param File
	 *            file 上传文件
	 * @param String
	 *            dirName 文件目录名称 （在oss中不存在目录一说，只是用于形象的区分文件种类）
	 * @param String
	 *            fileName 文件名
	 * @return Map<String, Object> map stauts :true 上传成功 。 false 上传失败 msg
	 *         :成功，返回文件路径。失败，返回失败信息
	 */
	public boolean uploadFileOSS(File file, String dirName, String fileName) {
		OSSClient ossClient = openOssClient();
		boolean uploadStatus = true;
		String ret = "";// 上传完成返回签名
		String uploadDir = "";// 目录名
		String uploadPath = "";// 保存文件路径名称
		InputStream uploadInputStrem = null;
		if (!"".equals(dirName) && dirName != null) {
			uploadDir = dirName.substring(0, dirName.length()).replaceAll("\\\\", "/") + "/";
		}
		try {
			// 获取上传文件后缀名
			if (file != null) {
				String fileSuffix = CONSTANT_COMMON_SPOT + getExtensionName(file);
				uploadPath = uploadDir + fileName + fileSuffix;
				// 创建上传Object的Metadata。ObjectMetaData是用户对该object的描述
				ObjectMetadata objectMetadata = new ObjectMetadata();
				objectMetadata.setContentLength(file.length());
				objectMetadata.setCacheControl("no-cache");
				objectMetadata.setContentEncoding("utf-8");
				objectMetadata.setContentType(getcontentType(fileSuffix));// 获取文件类型
				objectMetadata.setContentDisposition("attachment;filename=" + fileName + fileSuffix);

				uploadInputStrem = new FileInputStream(file);
				// 上传文件
				logger.debug("正在上传文件到OSS...");
				PutObjectResult putResult = ossClient.putObject(aliyunOssConfig.getBucket(), uploadPath, uploadInputStrem, objectMetadata);
				logger.debug("上传文件完成...");
				ret = putResult.getETag();
				logger.debug("上传后的文件MD5数字唯一签名:{}", ret);
			}

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			uploadStatus = false;
			return uploadStatus;
		} finally {
			try {
				if (uploadInputStrem != null) {
					uploadInputStrem.close();// 关闭文件流
				}
				if (ossClient != null) {
					closeOssClient(ossClient);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (!"".equals(ret) && ret != null) {
			uploadStatus = true;
			return uploadStatus;
		} else {
			uploadStatus = false;
			return uploadStatus;
		}
	}

	/**
	 * @Title: downloadFile
	 * @Description: 下载文件
	 * @author: wangyun
	 * @date: 2018年4月20日 下午5:14:10
	 * @param client
	 * @param bucketName
	 * @param ossFilePath(fileId)
	 *            上传到OSS起的全路径名
	 * @param filename
	 *            文件下载到本地保存的路径
	 */
	public static void downloadFile(String ossFilePath, String filePath) {
		OSSClient ossClient = openOssClient();
		ossClient.getObject(new GetObjectRequest(aliyunOssConfig.getBucket(), ossFilePath), new File(filePath));
	}

	/**
	 * @Title: closeOssClient
	 * @Description: 关闭OSS存储对象
	 * @author: 李星江
	 * @date: 2017年1月3日 下午8:41:03
	 * @param ossClient
	 */
	public static void closeOssClient(OSSClient ossClient) {
		// 判断是否为空
		if (ossClient != null) {
			ossClient.shutdown();
		}
	}

	/**
	 * @Title: isExist
	 * @Description: 根据文件名判断文件是否存在
	 * @author: 李星江
	 * @date: 2017年1月3日 下午8:49:00
	 * @param fileName
	 * @return
	 */
	public Boolean isExist(String fileName) {
		OSSClient ossClient = null;
		try {
			if (StringUtils.isEmpty(fileName)) {
				return false;
			}
			ossClient = openOssClient();
			return ossClient.doesObjectExist(aliyunOssConfig.getBucket(), fileName);
		} finally {
			closeOssClient(ossClient);
		}
	}

	/**
	 * @Title: upload
	 * @Description: 通过MultipartFile上传文件
	 * @author: 李星江
	 * @date: 2017年1月4日 上午9:43:26
	 * @param multipartFile
	 * @return
	 */
	public String upload(MultipartFile multipartFile) {
		OSSClient ossClient = null;
		try {
			// 判断是否为空
			if (multipartFile != null) {
				// MultipartFile转换为File
				CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
				DiskFileItem fi = (DiskFileItem) cf.getFileItem();
				File file = fi.getStoreLocation();
				// 判断是否为空
				if (file != null) {
					String extension = getExtensionName(multipartFile.getOriginalFilename());
					if (StringUtils.isNotEmpty(extension)) {
						ossClient = openOssClient();
						// 随机文件名
						String fileName = UUID.randomUUID() + CONSTANT_COMMON_SPOT + extension;
						// 创建上传请求
						ObjectMetadata meta = getMetadata(extension);
						PutObjectRequest request = new PutObjectRequest(aliyunOssConfig.getBucket(), fileName, file, meta);
						ossClient.putObject(request);
						logger.debug("上传文件完成...");
						// 返回URL地址
						return getUrl(fileName, ossClient);
					}
				}
			}
		} catch (Exception e) {
			logger.error("通过MultipartFile上传文件异常,异常原因:{}", e);
		} finally {
			closeOssClient(ossClient);
		}
		return null;
	}

	/**
	 * @Title: upload
	 * @Description: 通过File上传文件
	 * @author: 李星江
	 * @date: 2017年1月3日 下午7:46:56
	 * @param file
	 * @return
	 */
	public String upload(File file) {
		OSSClient ossClient = null;
		try {
			// 判断是否为空
			if (file != null) {
				String extension = getExtensionName(file);
				if (StringUtils.isNotEmpty(extension)) {
					ossClient = openOssClient();
					// 随机文件名
					String fileName = UUID.randomUUID() + CONSTANT_COMMON_SPOT + extension;
					// 创建上传请求
					ObjectMetadata meta = getMetadata(extension);
					PutObjectRequest request = new PutObjectRequest(aliyunOssConfig.getBucket(), fileName, file, meta);
					ossClient.putObject(request);
					logger.debug("上传文件完成...");
					// 返回URL地址
					return getUrl(fileName);
				}
			}
		} catch (Exception e) {
			logger.error("通过File上传文件异常,异常原因:{}", e);
		} finally {
			closeOssClient(ossClient);
		}
		return null;
	}

	/**
	 * @Title: upload
	 * @Description: 上次文件
	 * @author: 李星江
	 * @date: 2017年3月10日 下午7:26:50
	 * @param inputStream
	 * @param extension
	 * @return
	 */
	public String upload(InputStream inputStream, String extension) {
		OSSClient ossClient = null;
		try {
			// 判断是否为空
			if (inputStream != null) {
				if (StringUtils.isNotEmpty(extension)) {
					ossClient = openOssClient();
					// 随机文件名
					String fileName = UUID.randomUUID() + CONSTANT_COMMON_SPOT + extension;
					// 创建上传请求
					ObjectMetadata meta = getMetadata(extension);
					PutObjectRequest request = new PutObjectRequest(aliyunOssConfig.getBucket(), fileName, inputStream, meta);
					ossClient.putObject(request);
					logger.debug("上传文件完成...");
					// 返回URL地址
					return getUrl(fileName);
				}
			}
		} catch (Exception e) {
			logger.error("通过File上传文件");
		} finally {
			closeOssClient(ossClient);
		}
		return null;
	}

	/**
	 * @Title: fileIdUpload
	 * @Description: 以HttpServletRequest方式上传
	 * @author: 李星江
	 * @date: 2017年8月17日 下午4:52:38
	 * @param request
	 * @param fieldName
	 *            属性名
	 * @return 上传文件实体信息
	 */
	public ScbidOssBean fileIdUpload(HttpServletRequest request, String fieldName) {
		ScbidOssBean uploadBean = null;
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			if (multipartRequest != null) {
				Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
				if (fileMap != null && fileMap.size() > 0) {
					MultipartFile multipartFile = fileMap.get(fieldName);
					if (multipartFile != null) {
						uploadBean = fileIdUpload(multipartFile);
					}
				}
			}
		}
		return uploadBean;
	}

	
	/**
	 * @Title: fileIdUpload
	 * @Description:通过MultipartFile方式上传,获取FileId
	 * @author: 李星江
	 * @date: 2017年8月8日 上午10:50:37
	 * @param multipartFile
	 * @return 上传文件实体信息
	 */
	public ScbidOssBean fileIdUpload(MultipartFile multipartFile) {
		OSSClient ossClient = null;
		ScbidOssBean uploadBean = null;
		try {
			if (multipartFile != null) {
				uploadBean = new ScbidOssBean();
				// 获取原文件名
				String name = multipartFile.getOriginalFilename();
				// 获取扩展名
				String extension = getExtensionName(name);
				// 获取文件输入流
				InputStream inputStream = multipartFile.getInputStream();
				if (inputStream != null) {
					ossClient = openOssClient();
					StringBuffer fileNameBuf = new StringBuffer();
					fileNameBuf.append(UUID.randomUUID());
					if (StringUtils.isNotEmpty(extension)) {
						fileNameBuf.append(CONSTANT_COMMON_SPOT);
						fileNameBuf.append(extension);
					}
					String fileId = fileNameBuf.toString();
					// 创建上传请求
					ObjectMetadata meta = getMetadata(extension);
					PutObjectRequest request = new PutObjectRequest(aliyunOssConfig.getBucket(),fileId, inputStream, meta);
					ossClient.putObject(request);
					logger.debug("上传文件完成...");
					uploadBean.setFileName(name);//上传文件原名
					uploadBean.setBucket(aliyunOssConfig.getBucket());//上传oss盘符
					uploadBean.setFileId(fileId);//上传文件名称
					uploadBean.setMenu("");
					
				}
			}
		} catch (Exception e) {
			logger.error("通过MultipartFile方式上传,获取fileId异常,异常原因{}", e);
		} finally {
			closeOssClient(ossClient);
		}
		return uploadBean;
	}
	
	/**
	 * @Title: getMetadata
	 * @Description: 获取数据类型
	 * @author: 李星江
	 * @date: 2018年1月12日 上午10:15:04
	 * @param extension
	 * @return
	 */
	public static ObjectMetadata getMetadata(String extension) {
		// 创建上传Object的Metadata
		ObjectMetadata meta = new ObjectMetadata();
		try {
			// 被下载时网页的缓存行为
			meta.setCacheControl("no-cache");
			// 设置上传内容类型
			String contentType = contentType(extension);
			if (StringUtils.isNotEmpty(contentType)) {
				meta.setContentType(contentType);
			}
		} catch (Exception e) {
			logger.error("获取数据类型异常,异常原因:{}", e);
		}
		return meta;
	}

	/**
	 * @Title: getUrl
	 * @Description: 获取文件URL
	 * @author: 李星江
	 * @date: 2017年11月17日 上午10:52:12
	 * @param fieldId
	 *            文件唯一标识符
	 * @param endpoint
	 * @param accessKey
	 * @param accessSecret
	 * @param bucket
	 * @return
	 */
	public String getUrl(String fieldId, String endpoint, String accessKey, String accessSecret, String bucket) {
		OSSClient ossClient = new OSSClient(aliyunOssConfig.getEndpoint(), aliyunOssConfig.getAccessKey(), aliyunOssConfig.getAccessSecret());
		return getUrl(fieldId, ossClient);
	}

	/**
	 * @Title: getExtranetUrl
	 * @Description: 获取外网地址
	 * @author: 李星江
	 * @date: 2018年1月30日 下午4:05:13
	 * @param fileId
	 * @return
	 */
	public String getExtranetUrl(String fileId,String bucket) {
		OSSClient ossClient = null;
		try {
			// 过期时间（毫秒数）
			Date expiration = new Date(new Date().getTime() + EXPIRE_TIME);
			ossClient = new OSSClient(aliyunOssConfig.getEndpoint(), aliyunOssConfig.getAccessKey(), aliyunOssConfig.getAccessSecret());
			URL url = ossClient.generatePresignedUrl(bucket, fileId, expiration);
			// 判断是否为空
			if (url != null) {
				return url.toString();
			}
			return null;
		} finally {
			closeOssClient(ossClient);
		}
	}

	/**
	 * @Title: getURL
	 * @Description: 获取上传文件URL地址
	 * @author: 李星江
	 * @date: 2017年1月3日 下午7:58:38
	 * @param fileName
	 * @return
	 */
	public String getUrl(String fileName) {
		OSSClient ossClient = null;
		try {
			// 过期时间（毫秒数）
			Date expiration = new Date(new Date().getTime() + EXPIRE_TIME);
			ossClient = openOssClient();
			URL url = ossClient.generatePresignedUrl(aliyunOssConfig.getBucket(), fileName, expiration);
			// 判断是否为空
			if (url != null) {
				return url.toString();
			}
			return null;
		} finally {
			closeOssClient(ossClient);
		}
	}

	/**
	 * @Title: getUrl
	 * @Description: 获取上传文件URL地址
	 * @author: 李星江
	 * @date: 2017年11月17日 上午10:58:07
	 * @param fileName
	 * @param bucket
	 * @return
	 */
	public String getUrl(String fileName, OSSClient ossClient) {
		try {
			if (ossClient != null) {
				// 过期时间（毫秒数）
				Date expiration = new Date(new Date().getTime() + EXPIRE_TIME);
				URL url = ossClient.generatePresignedUrl(aliyunOssConfig.getBucket(), fileName, expiration);
				// 判断是否为空
				if (url != null) {
					return url.toString();
				}
			}
			return null;
		} finally {
			closeOssClient(ossClient);
		}
	}

	/**
	 * @Title: deleteByName
	 * @Description: 通过文件名删除上传文件
	 * @author: 李星江
	 * @date: 2017年1月3日 下午8:57:46
	 * @param name
	 * @return
	 */
	public boolean deleteByName(String name) {
		OSSClient ossClient = null;
		// 对象不存在时也返回false
		if (isExist(name)) {
			try {
				ossClient = openOssClient();
				ossClient.deleteObject(aliyunOssConfig.getBucket(), name);
				return true;
			} catch (Exception e) {
				logger.error("通过文件名删除上传文件");
			} finally {
				closeOssClient(ossClient);
			}
		}
		return false;
	}

	/**
	 * @Title: isExistFile
	 * @Description: 根据URL地址判断文件时候存在
	 * @author: 李星江
	 * @date: 2017年5月12日 下午5:39:12
	 * @param url
	 *            原来的URL
	 * @return null:说明文件存在 <br/>
	 *         字符串:需要将新的url存入数据替换为原来的地址
	 */
	public String isExistFile(String url) {
		HttpURLConnection httpUrl = null;
		try {
			// 获得URL
			URL newUrl = new URL(url);
			httpUrl = (HttpURLConnection) newUrl.openConnection();
			httpUrl.connect();
			// 获得文件输入流
			httpUrl.getInputStream();
		} catch (Exception e) {
			int start = url.indexOf("com/") + 4;
			int end = url.indexOf("?");
			String fileName = url.substring(start, end);
			return getUrl(fileName);
		} finally {
			// 判断是否需要关闭
			if (httpUrl != null) {
				httpUrl.disconnect();
			}
		}
		return null;
	}

	/**
	 * @Title: contentType
	 * @Description: 获取文件类型
	 * @author: 李星江
	 * @date: 2018年1月12日 上午10:08:54
	 * @param fileType
	 * @return
	 */
	private static String contentType(String fileType) {
		fileType = fileType.toLowerCase();
		String contentType = "";
		switch (fileType) {
			case "bmp" :
				contentType = "image/bmp";
				break;
			case "gif" :
				contentType = "image/gif";
				break;
			case "png" :
			case "jpeg" :
			case "jpg" :
				contentType = "image/jpeg";
				break;
			case "html" :
				contentType = "text/html";
				break;
			case "txt" :
				contentType = "text/plain";
				break;
			case "vsd" :
				contentType = "application/vnd.visio";
				break;
			case "ppt" :
			case "pptx" :
				contentType = "application/vnd.ms-powerpoint";
				break;
			case "doc" :
			case "docx" :
				contentType = "application/msword";
				break;
			case "xml" :
				contentType = "text/xml";
				break;
			case "mp4" :
				contentType = "video/mp4";
				break;
			default :
				contentType = "application/octet-stream";
				break;
		}
		return contentType;
	}

	/**
	 * 判断OSS服务文件上传时文件的contentType
	 *
	 * @param CommonsMultipartFile
	 *            file 上传文件
	 * @param FilenameExtension
	 *            文件后缀
	 * @return String
	 */
	public static String getcontentType(String FilenameExtension) {

		if (FilenameExtension.equalsIgnoreCase(".bmp")) {
			return "image/bmp";
		}
		if (FilenameExtension.equalsIgnoreCase(".gif")) {
			return "image/gif";
		}
		if (FilenameExtension.equalsIgnoreCase(".jpeg") || FilenameExtension.equalsIgnoreCase(".jpg") || FilenameExtension.equalsIgnoreCase(".png") || FilenameExtension.equalsIgnoreCase(".jpz")) {
			return "image/jpeg";
		}
		if (FilenameExtension.equalsIgnoreCase(".html") || FilenameExtension.equalsIgnoreCase(".htm") || FilenameExtension.equalsIgnoreCase(".hts")) {
			return "text/html";
		}
		if (FilenameExtension.equalsIgnoreCase(".txt")) {
			return "text/plain";
		}
		if (FilenameExtension.equalsIgnoreCase(".vsd")) {
			return "application/vnd.visio";
		}
		if (FilenameExtension.equalsIgnoreCase(".pptx") || FilenameExtension.equalsIgnoreCase(".ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (FilenameExtension.equalsIgnoreCase(".docx") || FilenameExtension.equalsIgnoreCase(".doc")) {
			return "application/msword";
		}
		if (FilenameExtension.equalsIgnoreCase(".xml")) {
			return "text/xml";
		}
		if (FilenameExtension.equalsIgnoreCase(".xls")) {
			return "application/vnd.ms-excel";
		}
		if (FilenameExtension.equalsIgnoreCase(".xlsx")) {
			return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}
		if (FilenameExtension.equalsIgnoreCase(".zip")) {
			return "application/zip";
		}
		return null;
	}
	/**
	 * @Title: getExtensionName
	 * @Description: 通过file获取文件扩展名
	 * @author: 李星江
	 * @date: 2017年1月3日 下午7:00:02
	 * @param file
	 * @return
	 */
	public static String getExtensionName(File file) {
		// 判断文件是否为null
		if (file != null) {
			return getExtensionName(file.getName());
		}
		return null;
	}
	/**
	 * @Title: getExtensionName
	 * @Description: 获取文件扩展名
	 * @param fileName
	 * @return
	 */
	public static String getExtensionName(String fileName) {
		if (StringUtils.isNotEmpty(fileName) && fileName.length() > 0) {
			int dot = fileName.lastIndexOf('.');
			if ((dot > -1) && (dot < (fileName.length() - 1))) {
				return fileName.substring(dot + 1);
			}
		}
		return null;
	}

	
	/**
	  * @Title: getPostSignature
	  * @Description: 获取
	  * @author: wangyun
	  * @date: 2018年5月25日 下午3:12:26
	  * @param bucket
	  * @return
	 */
	public Map<String, String> getPostSignature(String bucket) {
		
		Map<String, String> respMap = new LinkedHashMap<String, String>();
		
		String endpoint = aliyunOssConfig.getEndpoint();
        String accessId = aliyunOssConfig.getAccessKey();
        String accessKey = aliyunOssConfig.getAccessSecret();
        String dir = "user-dir";
        String host = "http://" + bucket + CONSTANT_COMMON_SPOT + endpoint;
        OSSClient client = new OSSClient(endpoint, accessId, accessKey);
        try { 	
        	long expireTime = 30;
        	long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            //设置上传文件的大小限制
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            //设置该Policy的失效时间
            String postPolicy = client.generatePostPolicy(expiration, policyConds);
            
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = client.calculatePostSignature(postPolicy);
            
            respMap.put("accessid", accessId);
            respMap.put("accessKey", accessKey);
            respMap.put("policy", encodedPolicy);//policyBase64
            respMap.put("signature", postSignature);
            //respMap.put("expire", formatISO8601Date(expiration));
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
           
        } catch (Exception e) {
            
        }
		return respMap;
		
	}
}
