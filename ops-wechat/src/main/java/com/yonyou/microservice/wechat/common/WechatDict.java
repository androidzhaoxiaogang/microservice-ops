package com.yonyou.microservice.wechat.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jboss.logging.Logger;
import org.springframework.core.env.Environment;

import com.yonyou.cloud.common.reflection.SpringUtil;

/**
 * 微信信息类，
 * 从资源文件中拿到appid,appsecret,token,menuStr
 *
 */
public class WechatDict {
    private static Environment env;
    private static Logger logger=Logger.getLogger(WechatDict.class);
	static {
		logger.info("----WechatDict");
		env=(Environment)SpringUtil.getBean("environment");
		InputStream is = WechatDict.class.getResourceAsStream("/wechat.properties");
		Properties props = new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("----wechat.domain"+env.getProperty("wechat.domain"));
		logger.info("----wechat.appid"+env.getProperty("wechat.appid"));
		logger.info("----wechat.appsecret"+env.getProperty("wechat.appsecret"));
		logger.info("----wechat.token"+env.getProperty("wechat.token"));
		logger.info("----wechat.AESKey"+env.getProperty("wechat.AESKey"));
		appid = env.getProperty("wechat.appid");
		appsecret = env.getProperty("wechat.appsecret");
		token = env.getProperty("wechat.token");
		menuStr = props.getProperty("menu_str");
		AESKey = env.getProperty("wechat.AESKey");
	}
	
	public static String appid;

	public static String appsecret;
	
	public static String token;
	
	public static String menuStr;
	
	public static String AESKey;
	
	public static final String MESSAGE_TYPE_TEXT = "text"; //文本消息
	public static final String MESSAGE_TYPE_IMAGE = "image"; //图片消息
	public static final String MESSAGE_TYPE_VOICE = "voice"; //语音消息
	public static final String MESSAGE_TYPE_VIDEO = "video"; //视频消息
	public static final String MESSAGE_TYPE_SHORTVIDEO = "shortvideo"; //小视频消息
	public static final String MESSAGE_TYPE_MUSIC = "music"; //音乐消息
	public static final String MESSAGE_TYPE_NEWS = "news"; //图文消息
	public static final String MESSAGE_TYPE_LOCATION = "location"; //地理位置消息
	public static final String MESSAGE_TYPE_LINK = "link"; //链接消息
	public static final String MESSAGE_TYPE_EVENT = "event"; //事件
	

    /**
     * 消息结构常量定义
     */
    public final static String MSG_STRUCT_TOUSERNAME = "ToUserName";
    public final static String MSG_STRUCT_FROMUSERNAME = "FromUserName";
    public final static String MSG_STRUCT_CREATETIME = "CreateTime";
    public final static String MSG_STRUCT_MSGTYPE = "MsgType";
    public final static String MSG_STRUCT_MSGTYPE_TEXT = "text";
    public final static String MSG_STRUCT_CONTENT = "Content";
    public final static String MSG_STRUCT_MSGID = "ToUserName";
    public final static String MSG_STRUCT_PICURL = "PicUrl";
    public final static String MSG_STRUCT_MEDIAID = "MediaId";
    public final static String MSG_STRUCT_FORMAT = "Format";
    public final static String MSG_STRUCT_RECOGNITION = "Recognition";
    public final static String MSG_STRUCT_THUMBMEDIAID = "ThumbMediaId";
    public final static String MSG_STRUCT_LOCATION_X = "Location_X";
    public final static String MSG_STRUCT_LOCATION_Y = "Location_Y";
    public final static String MSG_STRUCT_SCALE = "Scale";
    public final static String MSG_STRUCT_LABEL = "Label";
    public final static String MSG_STRUCT_DESCRIPTION = "Description";
    public final static String MSG_STRUCT_TITLE = "Title";
    public final static String MSG_STRUCT_URL = "Url";
	
	public static final String EVENT_SUBSCRIBE = "subscribe"; //用户未关注时，进行关注后的事件推送
	public static final String EVENT_UNSUBSCRIBE = "unsubscribe"; //取消关注后的事件推送
	public static final String EVENT_SCAN = "SCAN"; //用户已关注时的事件推送
	public static final String EVENT_LOCATION = "LOCATION"; //上报地理位置事件
	public static final String EVENT_CLICK = "CLICK"; //自定义菜单事件
	public static final String EVENT_VIEW = "VIEW"; //点击菜单跳转链接时的事件推送

	public static final String TEMPLATE_APPOINTMENT_SUCCESS = "hgOXWcv0daobJ2kEob3xlVV7fP4b8RFex_LlbfWbI0s"; //预约成功模版id
	public static final String TEMPLATE_APPOINTMENT_EXPIRES = "9skhVE_e2X9a3_slcPo2Gqmh8_0AhpguQqjZGnpkavE";// 预约到期模版id
	public static final String TEMPLATE_EVENT = "avhmeFNqvoPkr8Q15C1VVIjzhhitDJjlSut2I01FC44";// 事件提醒模版id

    //用以区分xml标签
    public static final String XML_HEADING_NO_CONTENT = "xml_tag";
	//上传图文消息素材【订阅号与服务号认证后均可用】 
    public static final String WECHAT_URL_PIC_TEXT_CREATE = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";

    //替换=ACCESS_TOKEN
    public static final String WE_CHAT_REPLACESTR_ACCESS_TOKEN = "=ACCESS_TOKEN";
    
    //根据OpenID列表群发【订阅号不可用，服务号认证后可用】 
    public static final String WECHAT_URL_PIC_TEXT_BATCH_SEND = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
    
	// 获取access_token
	public static final String getAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	// 获取getticket  用于js-sdk验证
	public static final String getticketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=wx_card";

	// 获取用户授权code
	public static final String getCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	// 获取wechat的openid
	public static final String getOpenIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	// 刷新网页授权
	public static final String getRefreshTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	
	// 移动用户分组
	public static final String moveGroupUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	
	// 获取用户基本信息
	public static final String getOpenInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	// 发送模版消息
	public static final String sendTemplateMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

	// 创建自定义菜单
	public static final String createMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	// 删除自定义菜单
	public static final String deleteMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	// 创建带参二维码
	public static final String createQRCodeUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	
	// 通过ticket换取二维码
	public static final String getQRCodeUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	// 主动发送文本消息给个人微信
	public static final String sendTxtMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	//新增临时素材
    public static final String WECHAT_URL_MEDIA_UPLOAD = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    //新增图片
    public static final String WECHAT_URL_PIC_UPLOAD = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    //替换=TYPE
    public static final String WE_CHAT_REPLACESTR_TYPE = "=TYPE";
    //微信批量群发类型
    public static final String WE_CHAT_PICTEXT_BATCH_TYPE = "mpnews";

}
