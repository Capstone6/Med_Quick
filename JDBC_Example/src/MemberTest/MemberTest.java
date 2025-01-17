package MemberTest;

import java.util.ArrayList;
import vo.MemberVo;
import dao.MemberDAO;

public class MemberTest {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVo> list = dao.list();
		for(int i=0;i<list.size();i++) {
			MemberVo data =(MemberVo) list.get(i);
			String empno = data.getEmpno();
			String ename = data.getEname();
			int sal = data.getSal();
			
			System.out.println(empno + " " +ename + " " + sal);
		}
	}
}
