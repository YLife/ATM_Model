package entity;

import java.sql.Timestamp;

/**
 * ½»Ò×¼ÇÂ¼
 * @author YangLun
 *
 */
public class TradeInfo {
	private int tradeId;
	private String cardId;
	private int tradeType;
	private Timestamp tradeTime;
	private double tradeMoney;
	private String remark;
	
	public TradeInfo() {
		super();
	}

	public TradeInfo(int tradeId, String cardId, int tradeType,
			Timestamp tradeTime, double tradeMoney, String remark) {
		super();
		this.tradeId = tradeId;
		this.cardId = cardId;
		this.tradeType = tradeType;
		this.tradeTime = tradeTime;
		this.tradeMoney = tradeMoney;
		this.remark = remark;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	public Timestamp getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Timestamp tradeTime) {
		this.tradeTime = tradeTime;
	}

	public double getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(double tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
