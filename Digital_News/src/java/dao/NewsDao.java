/*
* NewsDao.java
*
* All Right Reserved
* Copyright (c) 2019 FPT University
*/
package dao;

import entity.News;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DBContext;

/**
 * NewsDao.<br>
 * 
 * <pre>
 * Class dùng các câu query để lấy dữ liệu từ database
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 * 
 * . GetNewsById.
 * . SearchNewsByTitle
 * . CountNewsWhenSearch
 * . GetTop5NewsRecent
 * 
  
 </pre>
 * 
 * @author FU QuanLHHE130736
 * @version 1.0
 */
public class NewsDao extends DBContext {
    /**
     * GetNewById.<br>
     * Truyền vào id và tìm bài báo có id trùng với id truyền vào.
     * 
     * @param id
     * @return a News
     */
    public News getNewById(int id) {
        String sql = "SELECT * FROM dbo.News WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setDescription(rs.getString("description"));
                n.setAuthor(rs.getString("author"));
                n.setDate(rs.getDate("date"));
                n.setImage(rs.getString("image"));
                return n;

            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * getTop1NewsById.<br>
     * Lấy ra bài báo đầu tiên theo id.
     * 
     * @param id
     * @return a News
     */
    public News getTop1NewsById() {
        String sql = "SELECT TOP(1)* FROM dbo.News ORDER BY id ASC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setDescription(rs.getString("description"));
                n.setAuthor(rs.getString("author"));
                n.setDate(rs.getDate("date"));
                n.setImage(rs.getString("image"));
                return n;

            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * SearchNewsByTitle.<br>
     * Tìm kiếm theo tiêu đề nhập vào , và trả về danh sách các bài báo thỏa mãn.
     * 
     * 
     * @param title
     * @param pageindex
     * @param pagesize
     * @return a list News
     */
    public ArrayList<News> searchNewsByTitle(String title,int pageindex, int pagesize) {
        ArrayList<News> listNews = new ArrayList<>();
        
        String sql = "SELECT * FROM(SELECT *,ROW_NUMBER() OVER (ORDER BY id ASC) as row_num "
                + "FROM dbo.News WHERE title LIKE ?) AS news WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            
            
            
            statement.setString(1, "%" + title + "%");
            
            statement.setInt(2, pageindex);
            statement.setInt(3, pagesize);
            statement.setInt(4, pageindex);
            statement.setInt(5, pagesize);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setDescription(rs.getString("description"));
                n.setAuthor(rs.getString("author"));
                n.setDate(rs.getDate("date"));
                n.setImage(rs.getString("image"));
                listNews.add(n);

            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNews;
    }
    /**
     * CountNewsWhenSearch.<br>
     * Đếm số bài báo thỏa mãn tiêu đề nhập vào.
     * 
     * @param title
     * @return a number of new
     */
    public int countNewsWhenSearch(String title){
        String sql = "SELECT COUNT(*) FROM dbo.News WHERE title LIKE ?";
         try (PreparedStatement statement = connection.prepareStatement(sql);) {
             
             
            statement.setString(1, "%" + title + "%");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
               return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return -1;
    }
    /**
     * GetTop5NewsRecent.<br>
     * Lấy ra 5 bài báo gần nhất.
     * 
     * @return a list new
     */
    public ArrayList<News> getTop5NewsRecent() {
        ArrayList<News> listNews = new ArrayList<>();
        String sql = "SELECT TOP(5)* FROM News ORDER BY date DESC";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setDescription(rs.getString("description"));
                n.setAuthor(rs.getString("author"));
                n.setDate(rs.getDate("date"));
                n.setImage(rs.getString("image"));
                listNews.add(n);

            }
        } catch (SQLException ex) {
            Logger.getLogger(NewsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNews;
    }
}
