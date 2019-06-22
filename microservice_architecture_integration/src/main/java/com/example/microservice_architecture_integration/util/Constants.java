package com.example.microservice_architecture_integration.util;

/**
 * @classname: Constants
 * @description: 常量集合
 */

public interface Constants {

	public static final class RetCode {
		/** 返回成功 */
		public static final String RET_CODE_SUCCESS = "200";
		/** 返回失败 */
		public static final String RET_CODE_FAIL = "201";

	}
	//返回码值
	public static final class StatusCode {
		/** 返回成功 */
		public static final String RET_CODE_SUCCESS = "1";
		/** 返回失败 */
		public static final String RET_CODE_FAIL = "2";
		
	}
	//返回码值
	public static final class RetCodeMessage {
		/** 返回成功 */
		public static final String RET_CODE_SUCCESS = "成功";
		/** 返回失败 */
		public static final String RET_CODE_FAIL = "失败";

		public static final String DES = "文件ID为：fileId第currentUploadTime次文件上传成功！文件流大小为：fileMaxLength";

	}
	//是否删除
	public static final class IsDelete {
		/**未删除 */
		public static final String IS_DELETE_N = "N";
		/**删除*/
		public static final String IS_DELETE_Y = "Y";
	}

	public static final class CurrentStatus  {
		/**0：未转换，*/
		public static final String UNCONVERTED = "0";
		/**1：转换中*/
		public static final String CONVERSION = "1";
		/**2：已完成*/
		public static final String COMPLETED = "2";
		/**3：转换失败*/
		public static final String FAILURE = "3";
	}

	public static final class ConversionStatus  {
		public static String Conversion (int i){
			String status = "";
			if(i==0){
				status = "转换成功！";
			}else if(i==1){
				status = "找不到指定文档！";
			}else if(i==2){
				status = "无法打开指定文档！";
			}else if(i==3){
				status = "操作失败！";
			}else if(i==4){
				status = "转换的文档为加密文档或密码有误，请重新添加password参数进行转换！";
			}else if(i==5){
				status = "输出文档后缀错误！";
			}else if(i==6){
				status = "授权文件过期！";
			}else if(i==7){
				status = "转换超时，内容可能不完整！";
			}else if(i==8){
				status = "无效参数！";
			}else if(i==17){
				status = "上传失败！";
			}else if(i==18){
				status = "下载文件失败！";
			}else if(i==19){
				status = "文件过大！";
			}else if(i==20){
				status = "下载成功！";
			}else if(i==21){
				status = "删除失败！";
			}else if(i==22){
				status = "获取文件信息失败！";
			}else if(i==23){
				status = "URL编码失败！";
			}else if(i==24){
				status = "生成文件名为空,有误或重名,请检查参数！";
			}else if(i==25){
				status = "html转pdf转换失败！";
			}
			return status;
		}
	}
}