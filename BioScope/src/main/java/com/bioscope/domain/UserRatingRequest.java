//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.29 at 02:53:40 AM CDT 
//


package com.bioscope.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;choice>
 *           &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="movieName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="movieId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reviewDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "userName",
    "userId",
    "movieName",
    "movieId",
    "rating",
    "reviewDescription"
})
@XmlRootElement(name = "UserRatingRequest", namespace = "http://com/blog/samples/webservices/userRatingService")
public class UserRatingRequest {

    @XmlElement(namespace = "http://com/blog/samples/webservices/userRatingService")
    protected String userName;
    @XmlElement(namespace = "http://com/blog/samples/webservices/userRatingService")
    protected String userId;
    @XmlElement(namespace = "http://com/blog/samples/webservices/userRatingService")
    protected String movieName;
    @XmlElement(namespace = "http://com/blog/samples/webservices/userRatingService")
    protected String movieId;
    @XmlElement(namespace = "http://com/blog/samples/webservices/userRatingService", required = true)
    protected String rating;
    @XmlElement(namespace = "http://com/blog/samples/webservices/userRatingService", required = true)
    protected String reviewDescription;

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the movieName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * Sets the value of the movieName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieName(String value) {
        this.movieName = value;
    }

    /**
     * Gets the value of the movieId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * Sets the value of the movieId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieId(String value) {
        this.movieId = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRating(String value) {
        this.rating = value;
    }

    /**
     * Gets the value of the reviewDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewDescription() {
        return reviewDescription;
    }

    /**
     * Sets the value of the reviewDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewDescription(String value) {
        this.reviewDescription = value;
    }

}
