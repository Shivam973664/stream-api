package abc.test;


import java.util.HashMap;
import java.util.Map;

public class JpMorganChaseRound1 {
//  
//	3AaA2bbBzZ3pqrRRRp
//	AaA : 3 ,bbB : 3 , rRRR : 4
//	
//	
	
	public static void main(String[] args) {
//		
		String input ="ZZZZZ333AaA2bbbbBazZ3pqrRRRp";
		StringBuilder temp = new StringBuilder();
		boolean caseSensitive=false;
		temp.append(input.charAt(0));
		char preVchar=input.charAt(0);
		int countPrevChar=1;
		Map<String,Integer> map = new HashMap<>();
		for(int i=1;i<input.length();i++) {
//			if(Character.toUpperCase(preVchar)==Character.toUpperCase(input.charAt(i))) {
//			if(preVchar==input.charAt(i)) {
			if(caseSensitive ? preVchar==input.charAt(i) : Character.toUpperCase(preVchar)==Character.toUpperCase(input.charAt(i))) {
				
				temp.append(input.charAt(i));
				countPrevChar++;
			}else {
				if(countPrevChar>=3) {
					map.put(temp.toString(),countPrevChar);	
					
				}
				countPrevChar=1;
				preVchar=input.charAt(i);
				temp.setLength(0);
				temp.append(preVchar);
//				countPrevChar++;
			}
		}
		if(countPrevChar>=3) {
			map.put(temp.toString(),countPrevChar);	
		}
		map.forEach((a,b)-> System.out.println(a + " " + b));
	}
}


/*
 * 
 * 
 * given one table employee(id,salary,department_id,name,company_id)
department(id,department,location,company_id)
company(id,name,address)

select cmp.name,p.salary from company cmp 
left join
(select emp.department_id as dept_id,emp.company_id as company_id,sum(emp.salary) as salary from employee emp
group by emp.department_id,emp.company_id order by sum(emp.salary) limit 1) p
on cmp.id= p.company_id ;

@Service
public class EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepository;


	private EntityManager em;



@Transational
public boolean saveEmployeeDeptCompany(EmployeeDTo empdto,CompanyDTO compDto, DepartmentDTO deptmentDTO){
	
	EmployeeData empdata= new EmployeeData();
	empdata= EmployeeDataBuilder.setEmpoyeeDTO(empdto).build();
	
	CompanyData cmpdata= new CompanyData();
	cmpdata= CompanyDataBuilder.setCompanyDTO(compDto).build();
	
	DepartmentData deptdata= new EmployeeData();
	deptdata= DepartmentDataBuilder.setDeprtmentDTO(deptmentDTO).build();

	

	try{
		deptdata.setCompanyData(compData);
		empRepository.persist(deptdata);
		empRepository.flush();
		empdata.setDepartment(deptdata);
		cmpdata.set(deptdata);
	}catch(Exception exc){
		logger.info("not able to store" + exc.getStackTrace());

	}

	empRepository.persist(empdata);
	empRepository.persist(cmpdata);
	
	
	
	
}


}



interface EmployeeRepository extends JpaRepository<EmployeeData,Long>{

}
 */

