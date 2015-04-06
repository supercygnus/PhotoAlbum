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
	
	public List photo_queryList(String condition){
		Photo photo=null;
		list=new ArrayList();
		sql="select * from tb_photo";
		if(condition!=null){
			sql="select * from tb_Photo where "+condition;
		}
		
		ResultSet rs=jdbc.executeQuery(sql);
		
		try{
			while(rs.next()){
				photo=new Photo();
				photo.setId(rs.getInt(1));
				photo.setPhotoName(rs.getString(2));
				photo.setPhotoSize(rs.getString(3));
				photo.setPhotoType(rs.getString(4));
				photo.setPhotoTime(rs.getString(5));
				photo.setPhotoAddress(rs.getString(6));
				photo.setUsername(rs.getString(7));
				photo.setPrintAddress(rs.getString(8));
				photo.setSmallPhoto(rs.getString(9));
				list.add(photo);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			list=null;
		}
		finally{
			jdbc.closeConnection();
		}
		return list;
	}
	
}
