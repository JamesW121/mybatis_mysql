package tools;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import Dbatis.ItemMapper;
import bean.Item1;

public class DB_operation {

	public DB_operation() {
		// TODO Auto-generated constructor stub
	}
	
	public static void insert(Item1 item) {
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
 
   public static void delete(int id){
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
    
    
   public static void selectById(int id){
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
    
    public static ArrayList<Item1> selectAll(){
        SqlSession session=DBhelper.getSession();
        ItemMapper mapper=session.getMapper(ItemMapper.class);
        ArrayList<Item1> user = new ArrayList<Item1>();
        
        try {
        user=(ArrayList<Item1>) mapper.selectAllItem();
        System.out.println(user.size());
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
		return user;
    }

}
