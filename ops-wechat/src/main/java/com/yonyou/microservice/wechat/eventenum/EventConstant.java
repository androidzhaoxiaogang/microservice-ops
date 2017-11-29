package com.yonyou.microservice.wechat.eventenum;

/**
 * 业务事件定义
 * 
 * @author BENJAMIN
 *
 */
public class EventConstant {

	/**
	 * 业务场景定义
	 * 
	 * @author BENJAMIN
	 *
	 */
	public enum EventBizType {
		REGISTER(1001), // 完整注册
		RECOMMAND_INFO(1002), // 推荐留资
		REPAIR_APPOINTMENT(1003), // 养修预约预约
		REPAIR_ORDER(1004), // 维修过程
		RECOMMAND_CARORDER(1005), // 推荐购车
		WECHAT_RELATION(1006), // 微信
		ACTIVITY_INFO(1007), // 活动资讯
        QUESTIONNAIRE(1009), // 提交调查问卷
		COMMON(9001),// 手动积分事件
		POINT_ACTIVITY(1010),//积分活动
		/**
		 * 商城下单事件
		 */
		SHOPPIING_ORDER(1008);
		

		;

		private final Integer type;

		EventBizType(Integer type) {
			this.type = type;
		}

		public String toString() {
			return type.toString();
		}

		public Integer getCode() {
			return type;
		}

		public Long getCodeLong() {
			return new Long(type);
		}
	}

	/**
	 * 业务节点定义
	 * 
	 * @author BENJAMIN
	 *
	 */
	public enum EventBizStep {
		REGISTER_SIGNIN(10011001), // 完成注册
		REGISTER_BIND(10011002), // 车辆认证
		REGISTER_RECORD_SYNC(10011003), // 维修履历同步

		RECOMMAND_INFO_EFFECTIVE(10021001), // 推荐留资有效
		RECOMMAND_INFO_SEND(10021002), // 留资信息发送

		REPAIR_APPOINTMENT_ARRIVED(10031001), // 养修预约到达
		REPAIR_APPOINTMENT_WARN(10031002), // 养修预约提醒
		REPAIR_APPOINTMENT_CONFIRM_INFORM(10031003), // 养修预约已确认通知
		REPAIR_APPOINTMENT_SEND(10031004), // 养修预约信息发送

		REPAIR_ORDER_EVALUATED(10041001), // 维修工单评价完成

		RECOMMAND_CARORDER_ORDERED(10051001), // 推荐购车下单ed
		RECOMMAND_CARORDER_INFO_SEND(10051002), // 推荐购车信息发出
		RECOMMAND_CARORDER_LEADS_INVALID(10051003), //推荐购车线索无效

		COMMON_POINTS_CHANGED(90011001), // 积分变更事件,
		COMMON_POINTS_MANUAL(90011002), // 手动积分变更,
		COMMON_POINTS_DEDUCT(90011003), // DCMS扣减积分,
		COMMON_POINTS_RETURN(90011004), // DCMS扣减积分返还,
		

		ACTIVITY_INFO_READ(10071001), // 阅读到达积分数
		
		QUESTIONNAIRE_COMMIT(10091001),  // 提交调查问卷

		WECHAT_USER_ATTENTION(10061001), // 用户关注微信事件
		WECHAT_MASS_SEND(10061002), // 微信消息群发
		WECHAT_USER_UNATTENTION(10061003), // 用户取消关注微信事件
		POINT_ACTIVITY_GET_POINT(10101001),// 积分活动
		
		
		/**
		 * 用户下单后有一连串的事件需要去监听
		 * 事件		监听方			逻辑
		 * 用户点下单	 积分			积分进行积分扣除
		 * 积分成功	 商城		商城改变订单状态，进行JD接口调用
		 * 积分失败	 商城		商城改变订单状态
		 * JD下单成功	 商城		商城改变订单状态
		 * JD下单失败	 商城，积分	商城改变订单状态，积分还给客户
		 */
		//SHOPPIING_ORDER_TOPAY(10081001),//	用户下单动作
		SHOPPIING_ORDER_POINTS(10081002),	// JD下单失败返还积分
		SHOPPIING_ORDER_JD(10081003)	//JD订单提交结果
		
		;

		private final Integer type;

		EventBizStep(Integer type) {
			this.type = type;
		}

		public String toString() {
			return type.toString();
		}

		public Integer getCode() {
			return type;
		}

		public Long getCodeLong() {
			return new Long(type);
		}
	}
}
