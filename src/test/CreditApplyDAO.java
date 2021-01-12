package test;

import java.util.ArrayList;
import java.util.List;

public class CreditApplyDAO {
	private static CreditApplyDAO instance;
	private static List<CreditApply> creditData = new ArrayList<>();
	
	//dummy data
	static {
		creditData.add(new CreditApply(1, "Tom", "Smith", 156254788, 60000));
		creditData.add(new CreditApply(2, "Jerry", "Burger", 253685477, 50000));
	}
	
	private CreditApplyDAO() {}
	
	public static CreditApplyDAO getInstance() {
		if (instance==null) {
			instance = new CreditApplyDAO();
		}
		return instance;
	}
	

	public List<CreditApply> listAll(){
		return new ArrayList<CreditApply>(creditData);
	}
	
	public int add(CreditApply creditObj) {
		int newId= creditData.size()+1;
		creditObj.setId(newId);
		creditData.add(creditObj);
		return newId;
	}
	
	public CreditApply get(int id) {
		CreditApply idFinder = new CreditApply(id);
		int index = creditData.indexOf(idFinder);
		if (index>=0){
			return creditData.get(index);
			
		}
		return null;
	}
	
	public boolean update(CreditApply creditApp) {
		int index = creditData.indexOf(creditApp);
		if(index>=0) {
			return true;
		}
		return false;
	}
	
	public boolean delete(CreditApply creditApp) {
		int index = creditData.indexOf(creditApp);
		if(index>=0) {
			creditData.remove(index);
		}
		return false;
	}
	
}