/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package com.roncoo.pay.service.point.exceptions;

import com.roncoo.pay.common.core.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户服务业务异常类,异常代码8位数字组成,前4位固定1001打头,后4位自定义
 * 
 * @author Along
 * 
 */
public class PointBizException extends BizException {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PointBizException.class);

	public static final PointBizException ACCOUNT_NOT_EXIT = new PointBizException(10010001, "账户不存在");
	public static final PointBizException ACCOUNT_SUB_AMOUNT_OUTLIMIT = new PointBizException(10010002, "余额不足，减款超限");
	public static final PointBizException ACCOUNT_UN_FROZEN_AMOUNT_OUTLIMIT = new PointBizException(10010003, "解冻金额超限");
	public static final PointBizException ACCOUNT_FROZEN_AMOUNT_OUTLIMIT = new PointBizException(10010004, "冻结金额超限");
	public static final PointBizException ACCOUNT_TYPE_IS_NULL = new PointBizException(10010005, "账户类型不能为空");

	public PointBizException() {
	}

	public PointBizException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
	}

	public PointBizException(int code, String msg) {
		super(code, msg);
	}

	/**
	 * 实例化异常
	 * 
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public PointBizException newInstance(String msgFormat, Object... args) {
		return new PointBizException(this.code, msgFormat, args);
	}

	public PointBizException print() {
		logger.info("==>BizException, code:" + this.code + ", msg:" + this.msg);
		return this;
	}
}
