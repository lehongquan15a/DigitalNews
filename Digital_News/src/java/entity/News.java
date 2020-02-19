/*
* News.java
*
* All Right Reserved
* Copyright (c) 2019 FPT University
*/
package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;




/**
 * News.<br>
 * 
 * <pre>
Class mô tả đối tượng News
Trong class này sẽ tiến hành các xử lí dưới đây
 
 . GetId.
 . SetId.
 . GetTitle.
 . SetTile.
 . GetDescription.
 . SetDescription.
 . GetAuthor.
 . SetAuthor.
 . GetDate.
 . SetDate.
 . GetImage.
 . SetImage.
 . ToString.
 
 </pre>
 * 
 * @author FU QuanLHHE130736
 * @version 1.0
 */
public class News {
    /**Store id.*/
    private int id;
    /**Store title.*/
    private String title;
    /**Store description.*/
    private String description;
    /**Store author.*/
    private String author;
    /**Store date.*/
    private Date date;
    /**Store image.*/
    private String image;
    
    /**
     * Constructor.<br>
     */
    public News() {
    }
    /**
     * Constructor full parameter<br>
     * @param id
     * @param title
     * @param description
     * @param author
     * @param date
     * @param image
     */
    public News(int id, String title, String description, String author, Date date, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = date;
        this.image = image;
    }

    
    /**
     * Get id.<br>
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * Set id.<br>
     * 
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get title.<br>
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Set title.<br>
     * 
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Get description.<br>
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Set description.<br>
     * 
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Get author.<br>
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Set author.<br>
     * 
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Get date and format date.<br>
     * 
     * @return the date
     */
    public String getDate() {
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy-hh:mm");
//        String date = sdf.format(this.date);
//        int hour = Integer.parseInt(date.substring(12,14));
//        if(hour>0&&hour<12){
//            date+="am";
//        }else{
//            date+="pm";
//        }
        return sdf.format(this.date);
    }
    /**
     * Set date.<br>
     * 
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Get image.<br>
     * 
     * @return the image
     */
    public String getImage() {
        return image;
    }
    /**
     * Set image.<br>
     * 
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    /**
     * To String.<br>
     * 
     * @return a string describle a News
     */
    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", description=" + description + ", author=" + author + ", date=" + date + ", image=" + image + '}';
    }

    
    
    
}
