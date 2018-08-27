import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import bean.Item1;
import Dbatis.ItemMapper;
import tools.DBhelper;;

public class testing {

	public testing() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Item1 a = new Item1();
		a.setID(1);
		a.setValue("23ouh");
		
		insert(a);
	}
	
	 private static void insert(Item1 item) {
	        SqlSession session = DBhelper.getSession();
	        ItemMapper mapper = session.getMapper(ItemMapper.class);
	        try {
	            mapper.insertItem(item);
	            System.out.println(item.toString());
	             session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }
	    }
	    
	    
	    /**
	     * 删除用户
	     */
	    private static void delete(int id){
	        SqlSession session=DBhelper.getSession();
	        ItemMapper mapper=session.getMapper(ItemMapper.class);
	        try {
	            mapper.deleteItem(id);
	            session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }
	    }
	    
	    
	    /**
	     * 根据id查询用户
	     */
	    private static void selectById(int id){
	        SqlSession session=DBhelper.getSession();
	        ItemMapper mapper=session.getMapper(ItemMapper.class);
	        try {
	        	Item1 user= mapper.selectItemById(id);
	        System.out.println(user.toString());
	            
	            session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }
	    }
	    
	    /**
	     * 查询所有的用户
	     */
	    private static void selectAll(){
	        SqlSession session=DBhelper.getSession();
	        ItemMapper mapper=session.getMapper(ItemMapper.class);
	        try {
	        ArrayList<Item1> user=(ArrayList<Item1>) mapper.selectAllItem();
	        System.out.println(user.size());
	        session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }
	    }
	    
}
