package com.zyj.sessionClient.entry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "DeliverySession")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliverySessionCreationType", propOrder = {
    "deliverySessionId",
    "action",
    "tmgiPool",
    "tmgi",
    "startTime",
    "stopTime"
})
public class DeliverySessionCreationType {

    @XmlElement(name = "DeliverySessionId")
    @XmlSchemaType(name = "unsignedInt")
    protected long deliverySessionId;
    @XmlElement(name = "Action", required = true)
    @XmlSchemaType(name = "string")
    protected ActionType action;
    @XmlElement(name = "TMGIPool")
    protected String tmgiPool;
    @XmlElement(name = "TMGI")
    protected String tmgi;
    @XmlElement(name = "StartTime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long startTime;
    @XmlElement(name = "StopTime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long stopTime;
    @XmlAttribute(name = "Version", required = true)
    protected String version;

    /**
     * getDeliverySessionId
     * 
     */
    public long getDeliverySessionId() {
        return deliverySessionId;
    }

    /**
     * setDeliverySessionId
     * 
     */
    public void setDeliverySessionId(long value) {
        this.deliverySessionId = value;
    }

    /**
     * getAction()
     * 
     * @return
     *     possible object is
     *     {@link ActionType }
     *     
     */
    public ActionType getAction() {
        return action;
    }

    /**
     * setAction
     * 
     * @param value
     *     allowed object is
     *     {@link ActionType }
     *     
     */
    public void setAction(ActionType value) {
        this.action = value;
    }

    /**
     * getTMGIPool
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTMGIPool() {
        return tmgiPool;
    }

    /**
     * setTMGIPool
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTMGIPool(String value) {
        this.tmgiPool = value;
    }

    /**
     * getTMGI
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTMGI() {
        return tmgi;
    }

    /**
     * setTMGI
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTMGI(String value) {
        this.tmgi = value;
    }

    /**
     * getStartTime
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * setStartTime
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartTime(Long value) {
        this.startTime = value;
    }

    /**
     * getStopTime
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStopTime() {
        return stopTime;
    }

    /**
     * setStopTime
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStopTime(Long value) {
        this.stopTime = value;
    }

    /**
     * getVersion
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * setVersion
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
