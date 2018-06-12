package hello;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class MysqlDemo {


	public static void main(String[] args) throws Exception {
		Connection conn = null;
		String sql;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
		// 避免中文乱码要指定useUnicode和characterEncoding
		// 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
		// 下面语句之前就要先创建javademo数据库
		String url = "jdbc:mysql://dcdbt-2jr9duxj.sql.tencentcdb.com:6/palm_doctor?"
				+ "user=dcdbpalm&password=dcdbpalm_0521&useUnicode=true&characterEncoding=UTF8";

		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			// or:
			// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			// or：
			// new com.mysql.jdbc.Driver();

			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			//sql = "      select distinct SO.ID AS ID,SO.ASSIGNTYPE AS ASSIGNTYPE,SO.ASSOCIATED_OBJ AS ASSOCIATED_OBJ,SO.DIAGNOSIS AS DIAGNOSIS,SO.DIAGNOSISCONCLUSION AS DIAGNOSISCONCLUSION,SO.DIAGNOSISPROPOSAL AS DIAGNOSISPROPOSAL,SO.HISSUMMARY AS HISSUMMARY,SO.LAST_MODIFIED AS LAST_MODIFIED,SO.NOTE AS NOTE,SO.PRICE AS PRICE,SO.PRICE_UNIT AS PRICE_UNIT,SO.REFUSEREASON AS REFUSEREASON,SO.REQUEST_ACCOUNT AS REQUEST_ACCOUNT,SO.REQUIREMENT AS REQUIREMENT,SO.RESPONSE_ACCOUNT AS RESPONSE_ACCOUNT,SO.SERVICE_PACKAGETYPE AS SERVICE_PACKAGETYPE,SO.STATUS AS STATUS,SO.WEIGHTS AS WEIGHTS,SO.TRANSACTION_NO AS TRANSACTION_NO,SO.DOCTOR AS DOCTOR,SO.PATIENT AS PATIENT,SO.CONJOINEDTWINS AS CONJOINEDTWINS,SO.PRE_ACCEPT_ACCOUNTS AS PRE_ACCEPT_ACCOUNTS,SO.EFFECTIVE_DATE AS EFFECTIVE_DATE,SO.INVALID_DATE AS INVALID_DATE,  OS.ID AS OID,OS.ANESTHESIAMODE,OS.ANESTHESIOLOGIST,OS.OPDATE,OS.OPDEPARTMENT,OS.OPENDDATE,OS.OPHOSPITAL,OS.OPNAME,OS.OPPOSITION,OS.OPSTARTDATE,  TS.ID AS TSID,TS.TRANSTYPE,TS.SUGGESTHOSPITAL,TS.OUTHOSPITAL,TS.INHOSPITAL,TS.SICKROOMNO,TS.BEDNO,TS.CONTACTPHONE,TS.APPOINTMENTDATE,  SOA.HAS_READ AS READ1,HS.HAS_READ AS READ2 from L_SERVICE_ORDER SO left JOIN L_SERVICE_ORDER_ACCOUNT SOA on SO.ID=SOA.ORDERID AND SOA.ACCOUNT = 71 left join L_OFFSITEOPERATION_SERVICE_ORDER OS on SO.ID=OS.ID  left join L_TRANSFERHOSPITAL_SERVICE_ORDER TS on SO.ID=TS.ID  left join L_ORDER_ACCOUNT_HAS_READ HS on SO.ID=HS.ORDER_ID AND HS.ACCOUNT_ID = 71 where 1=1  AND ( ( SO.REQUEST_ACCOUNT=71 OR SO.RESPONSE_ACCOUNT=71 OR SOA.ACCOUNT=71)) AND ( SO.STATUS IN(4) OR ( SO.REQUEST_ACCOUNT = 71 && SO.STATUS = 5 ) OR ( SO.REQUEST_ACCOUNT = 71 && SO.STATUS = 6 )) AND (SO.SERVICE_PACKAGETYPE != 6 || SO.SERVICE_PACKAGETYPE = 6 && SO.ASSOCIATED_OBJ  IS NULL )  AND (SO.SERVICE_PACKAGETYPE != 0 || SO.SERVICE_PACKAGETYPE = 0 && SO.ASSOCIATED_OBJ  IS NULL )  ORDER BY (IFNULL(READ1,1)+ IFNULL(READ2,1)) ASC, SO.WEIGHTS DESC, SO.LAST_MODIFIED DESC  LIMIT 0,20 ";
			//sql =" insert into q_account (id,name) values (100055,'测试')";
			sql =" select  t.ID as id, t.STATUS as status, t.IS_AUTHORIZED as isAuthorized, t.APPLAYSKILL as applayskill, t.APPLY_DEPARTMENT as applyDepartment, t.APPLY_HOSPITAL as applyHospital, t.APPLY_MAJORID as applyMajorid, t.APPLYREASON as applyreason, t.APPLY_TITLE as applyTitle, t.BIRTHDAY as birthday, t.CITY as city, t.CONSULTATION_PRICE as consultationPrice, t.CONSULTATIONED as consultationed, t.COUNTRY as country, t.CREATE_DATE as createDate, t.joinDifficultConsultation as joinDifficultConsultation, t.joinClinicConsultation as joinClinicConsultation, t.DEPARTMENTALIAS as departmentalias, t.DCS_PRICE as dcsPrice, t.FAMILYED as familyed, t.HOSPITALALIAS as hospitalalias, t.IDCARD as idcard, t.MAJORID as majorId, (SELECT name FROM d_major_department md WHERE md.id = t.MAJORID) as majorName , t.DEPARTMENT as departmentId, (SELECT name FROM d_department d WHERE d.id = t.DEPARTMENT) as departmentName , t.HOSPITAL as hospital, (SELECT name FROM d_hospital h WHERE h.id = t.HOSPITAL) as hospitalName , (SELECT name FROM q_account a WHERE a.id = t.id) as doctorName , t.OPERATION_PRICE as operationPrice, t.OPERATIONED as operationed, t.PROVINCE as province, t.SEX as sex, t.SKILL as skill, t.SUSPENDEND as suspendend, t.SUSPENDSTART as suspendstart, t.TITLE as title, t.VISTITED as vistited, t.DOORSER_ADDRESS as doorserAddress, t.DOORSER_CITYID as doorserCityid, t.DOORSER_COUNTYID as doorserCountyid, t.DOORSER_PRICE as doorserPrice, t.DOORSER_PROVINCEID as doorserProvinceid, t.HALFYEARPRICE as halfyearprice, t.MONTHPRICE as monthprice, t.QUARTERPRICE as quarterprice, t.VIDEONO as videono, t.VOICENO as voiceno, t.YEARPRICE as yearprice, t.FOLLOWUPCOMMPRICE as followupcommprice, t.FOLLOWUPCOMMED as followupcommed, t.ISEFFECTIVE as iseffective, t.UPLOAD_IDCARD as uploadIdcard, t.UPLOAD_PRACTCERT as uploadPractcert, t.UPLOAD_QUALICERT as uploadQualicert, t.UPLOAD_TITLECERT as uploadTitlecert, t.UPLOADIDCARDTIME as uploadidcardtime, t.UPLOADPRACTCERTTIME as uploadpractcerttime, t.UPLOADQUALICERTTIME as uploadqualicerttime, t.UPLOADTITLECERTTIME as uploadtitlecerttime, t.TYPE as type, t.IDCARD_AUTHURL as idcardAuthurl, t.IDCARD_UNAUTHURL as idcardUnauthurl, t.PRACTCERT_AUTHURL as practcertAuthurl, t.PRACTCERT_UNAUTHURL as practcertUnauthurl, t.QUALICERT_AUTHURL as qualicertAuthurl, t.QUALICERT_UNAUTHURL as qualicertUnauthurl, t.TITLECERT_AUTHURL as titlecertAuthurl, t.TITLECERT_UNAUTHURL as titlecertUnauthurl, t.REMARK as remark from d_doctor t where 1 = 1  and t.id = 71  ";
			ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
			//stmt.executeUpdate(sql);// executeQuery会返回结果的集合，否则返回空值
			while (rs.next()) {
				System.out.println(rs.getString("doctorName") );// 入如果返回的是int类型可以用getInt()
				System.out.println(rs.getString("majorName") );// 入如果返回的是int类型可以用getInt()
			}

		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	
}
