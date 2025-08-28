package abc.test.fechapi;

public interface EmployeeRepository extends JpaRepostory<Ticket,Long>{
	
	@Query("select t from Ticket t fetch join user u where u.id:= id")
	public List<Ticket> getByUserId(Long id);
}
