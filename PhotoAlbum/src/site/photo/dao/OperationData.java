package site.photo.dao;

import java.util.*;

import site.photo.tool.JDBConnection;

public class OperationData {
	private JDBConnection jdbc=new JDBConnection();
	private List list = null;
	private String sql = null;
	
	public List queryPhotoList(){
		list=new ArrayList();
		return null;
	}
	
}
