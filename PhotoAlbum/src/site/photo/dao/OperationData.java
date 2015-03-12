package site.photo.dao;

import java.sql.ResultSet;
import java.util.*;

import site.photo.model.Photo;
import site.photo.tool.JDBConnection;

public class OperationData {
	private JDBConnection jdbc=new JDBConnection();
	private List list = null;
	private String sql = null;
	
	public List queryPhotoList(){
		list=new ArrayList();
		sql="select count(*) as number_count,photoType from tb_photo group by photoType";
		Photo photo=null;
		ResultSet rs=jdbc.executeQuery(sql);
		
		try{
			while(rs.next()){
				photo=new Photo();
				photo.setPhotoType(rs.getString("photoType"));
				photo.setNumber(rs.getInt("number_count"));
				list.add(photo);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			list=null;
		}
		
		jdbc.closeConnection();
		
		return list;
	}
	
}
