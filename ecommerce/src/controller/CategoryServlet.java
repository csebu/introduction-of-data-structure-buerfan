package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DBData;
import model.CategoryModel;



public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    DBData db = new DBData();
	
	
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = null;
		String action = request.getParameter("action");

		System.out.println("Value of Action" + action);
		System.out.println(action);
		
		if (action != null) {
			if (action.equals("new")) {
				CategoryModel categoryModel = new CategoryModel();
				request.setAttribute("categories", categoryModel);
				request.setAttribute("action", "new");
				
				rd = request.getRequestDispatcher("/newcategory.jsp");
				System.out.println("In new page..");
				
			}
		
			else if (action.equals("update")) {
				int id = Integer.parseInt(request.getParameter("id").toString());
				CategoryModel categoryModel = db.getCategoryById(id);
				
				request.setAttribute("categories", categoryModel);
				request.setAttribute("action", "update");
				
				rd = request.getRequestDispatcher("/newcategory.jsp");
			}
			
			else if (action.equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id").toString());
				CategoryModel categoryModel = new CategoryModel();
				categoryModel.setCategoryId(id);
				
				db.deleteCategory(categoryModel);
				List<CategoryModel> categoryModel1 = db.getAllCategories();
				request.setAttribute("categories", categoryModel1);
				rd = request.getRequestDispatcher("/index.jsp");	
			}
		}	else {
			
			List<CategoryModel> categoryModel = db.getAllCategories();
			request.setAttribute("categories", categoryModel);
			rd = request.getRequestDispatcher("/index.jsp");
		}
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String action = request.getParameter("action").toString();
		
		if (action.equals("new")) {
			CategoryModel category = new CategoryModel();
				
			category.setCategoryName(request.getParameter("name").toString());
			category.setCategoryDescription(request.getParameter("description").toString());
			
			db.saveCategory(category);
			
			List<CategoryModel> categoryModels = db.getAllCategories();
			request.setAttribute("categories", categoryModels);
			
			rd = request.getRequestDispatcher("/index.jsp");
		}
		
		else if (action.equals("update")) {
			CategoryModel category = new CategoryModel();
			category.setCategoryName(request.getParameter("name").toString());
			category.setCategoryDescription(request.getParameter("description").toString());
			
			category.setCategoryId(Integer.parseInt(request.getParameter("categoryId").toString()));
			
			db.updateCategory(category);
			
			List<CategoryModel> categoryModels = db.getAllCategories();
			request.setAttribute("categories", categoryModels);
			
			rd = request.getRequestDispatcher("/index.jsp");
			
		}
		
		rd.forward(request, response);
	}

}
