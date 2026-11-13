package test.deolitteusiOct;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
//	private List<UserRequest> userRequests;
	 static Map<Long,Integer> userRequests = new HashMap<>();

	private static final Integer thresholdWindow = 4;
	
	Main(){
		this.userRequests = new HashMap<>();
		this.userRequests.put(1l,0);
		this.userRequests.put(2l,0);
		this.userRequests.put(3l,0);
		this.userRequests.put(4l,0);
		
	}
	
	public static boolean addRequest(Long id) {
		
		if(userRequests.get(id)>thresholdWindow) {
			System.out.println("Limit is full");
			return false;
		}else {
			userRequests.put(id, userRequests.getOrDefault(id,0)+1);
			return true;
		}
	}
	
	

	public static void main(String[] args) {
		userRequests.put(1l, 0);
		
		Thread t1 = new Thread(()->{
			//user will provide input
			int count;
			Long userId=1l;
			while(addRequest(userId)) {
				System.out.println("Added Request Successfull for user "+ userId + " count " + userRequests.get(userId));
			}
		});
		
		t1.run();
		
		
		
		
		
		
		//Ratelimiting 
		//threshold
		//3 req/min :- user
		//multiple : user a :- send 4req/min
		///user b :- 4req/min : threshold
		///last min 
		///
		
		
		
	}
	
	
	
	
//	private static final Integer thresholdWindow = 4;
//	
//	private RateLimitingRepository repo;
//	
//	static boolean handleUserLimit(Long id) {
//		UserRequestCount userCount = repo.findBy(id);
//		if(userCount.getCount()>thresholdWindow) {
//			return false;
//		}else {
//			return true;
//		}
//	}

	
	//database
//	@Entity
//	@Table(name="users_request_count")
//	public class UserRequestCount{
//		
//		
//		@Id
//		@Column(name="user_id")
//		private Long userId;
//		
//		@Column(name="count")
//		private Integer count;
//	}
	
	
	//repository
	
//	interface RateLimitingRepository extends JpaRepository<UserRequestCount,Long>{
//		
//	}
}
