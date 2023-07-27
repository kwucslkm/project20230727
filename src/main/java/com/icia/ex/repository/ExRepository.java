package com.icia.ex.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.tools.DocumentationTool.DocumentationTask;

import com.icia.ex.dto.ExDTO;

public class ExRepository {
	Connection con = null; // DB 접속 관련 처리를 위한 객체
	PreparedStatement pstmt = null; // 쿼리문 전송 관련 처리를 위한 객체
	ResultSet rs = null; // select 결과를 담기 위한 객체
	// DB에 접속하기 위한 메서드. DAO 클래스의 모든 메서드가 시작전에 이 메서드를 호출해야 DB 작업 수행 가능.

	public Connection getConnection() throws Exception {

		// 이 메서드의 내용은 보통 평가지에서 제시함. (사용자 계정만 잘 구분하면 됨.)

		// 클래스를 로드 하는 역할(매개변수로 넘기는 클래스가 가지고 있는 필드, 메서드 종류, 클래스 이름 등을 JVM에 할당)
		// 인스턴스 생성 및 초기화를 해줌.
		// 컴파일 시점이 아니라 런타임 시점에 로딩을 할 수 있게 해줌.(DI랑 비슷한 역할)
		Class.forName("oracle.jdbc.OracleDriver"); // 사용할 DB 드라이버 로드
		// 접속할 DB 주소, 사용자 계정, 비밀번호
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "user1", "1234");
		return con;
	}

	public int save(String name, int age, String mobile) throws Exception {
		System.out.println("save 호출");
		System.out.println("name: " + name + " age: " + age + " mobile:" + mobile);
		// 1. DB 접속
		con = getConnection();
		// 2. 쿼리문 작성(변수 값을 넣을 부분은 물음표로 작성)
		String sql = "insert into ex_table(ex_name, ex_age, ex_mobile) values(?,?,?)";
		// 3. DB에 전송할 쿼리문 준비
		pstmt = con.prepareStatement(sql);
		// 4. 물음표 채우기
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		pstmt.setString(3, mobile);
		// 5. 쿼리문 실행
		int result = pstmt.executeUpdate();
		// 6. 실행 후 pstmt 종료
		pstmt.close();
		// 7. 접속 종료
		con.close();
		if (result == 1) {
			System.out.println("저장성공");
		}
		return result;

	}

	public List<ExDTO> findAll() throws Exception {
		con = getConnection();
		// 조회 결과를 담을 리스트
		List<ExDTO> list = new ArrayList<>();
		String sql = "select * from ex_table";
		pstmt =con.prepareStatement(sql);
		//select 쿼리 수행할 때는 executeQuery()  메서드
		rs=pstmt.executeQuery();
		// ResultSet의 next(): 조회결과(줄단위)가 있으면 true 리턴. 조회결과가 여러 줄이라면 while문의 조건으로 사용
		while(rs.next()) {
			ExDTO dto = new ExDTO();
			dto.setName(rs.getString(1)); // 조회결과 중 첫번째 컬럼값
			dto.setAge(rs.getInt(2)); // 정수 데이터 
			dto.setMobile(rs.getString(3));
			list.add(dto);
			
		}
		pstmt.close();
		con.close();
		return list;
		
		
	}
}
