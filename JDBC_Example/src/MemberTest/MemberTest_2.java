package MemberTest;

import java.util.ArrayList;
import dao.MemberDAO_Search;
import vo.MemberVo;
import java.io.*;

public class MemberTest_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input Search name....");
		String input = br.readLine();
		
		System.out.println(input + " Search Result");
		
		MemberDAO_Search dao = new MemberDAO_Search();
		ArrayList<MemberVo> list = dao.list(input);
		
		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String empno = data.getEmpno();
			String ename = data.getEname();
			int sal = data.getSal();

			System.out.println(empno + " " + ename + " " + sal);
		}
	}
}
