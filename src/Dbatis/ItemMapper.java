package Dbatis;

import java.util.List;
import bean.Item1;

	public interface ItemMapper {
	    public int insertItem(Item1 item) throws Exception;
	    public int updateItem (Item1 item,int id) throws Exception;
	    public int deleteItem(int id) throws Exception;
	    public Item1 selectItemById(int id) throws Exception;
	    public List<Item1> selectAllItem() throws Exception;
	}
