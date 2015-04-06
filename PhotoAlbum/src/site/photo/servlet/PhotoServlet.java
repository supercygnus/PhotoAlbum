package site.photo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.photo.dao.OperationData;
import site.photo.model.Photo;

/**
 * Servlet implementation class PhotoServlet
 */

public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("info");
		
		if(action.equals("forward_index")){
			this.forward_index(request, response);
		}
		else if(action.equals("queryPhotoList")){
			this.queryPhotoList(request, response);
		}
		else if(action.equals("queryOnePhoto")){
			this.queryOnePhoto(request, response);
		}
	}
	protected void forward_index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list=new OperationData().queryPhotoList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("photoIndex.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	protected void queryPhotoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void queryOnePhoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String condition="id='"+id+"'";
		List list=new OperationData().photo_queryList(condition);
		Photo photo=null;
		if(list.size()==1){
			photo=(Photo) list.get(0);
		}
		request.setAttribute("photo", photo);
		request.getRequestDispatcher("photoShow.jsp").forward(request, response);
	}
}
