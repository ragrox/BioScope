//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.01 at 06:08:39 AM CDT 
//


package com.bioscope.domain.userRatingService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RatingStatus" type="{http://com/blog/samples/webservices/userRatingService}EnumRatingStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ratingStatus"
})
@XmlRootElement(name = "userRatingResponse", namespace = "http://com/blog/samples/webservices/userRatingService")
public class UserRatingResponse {

    @XmlElement(name = "RatingStatus", namespace = "http://com/blog/samples/webservices/userRatingService", required = true)
    @XmlSchemaType(name = "string")
    protected EnumRatingStatus ratingStatus;

    /**
     * Gets the value of the ratingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EnumRatingStatus }
     *     
     */
    public EnumRatingStatus getRatingStatus() {
        return ratingStatus;
    }

    /**
     * Sets the value of the ratingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumRatingStatus }
     *     
     */
    public void setRatingStatus(EnumRatingStatus value) {
        this.ratingStatus = value;
    }

}
