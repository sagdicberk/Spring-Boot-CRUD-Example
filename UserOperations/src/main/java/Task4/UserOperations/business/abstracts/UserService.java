package Task4.UserOperations.business.abstracts;

import java.util.List;

import Task4.UserOperations.business.requests.CreateUserRequest;
import Task4.UserOperations.business.requests.UpdateUserRequest;
import Task4.UserOperations.business.responses.GetAllUserResponse;
import Task4.UserOperations.business.responses.GetByIdUserResponse;

public interface UserService {

	List<GetAllUserResponse> getAll();
	
	GetByIdUserResponse getById(int id);

	void add(CreateUserRequest createUserRequest);

	void delete(int id);

	void update(UpdateUserRequest updateUserRequest);
}

// bu sınıf içerisinde UserManager'ın içermesi gereken fonksiyonlar mevcut. 
// Interface olduğu için UserManager Classı bu fonksiyonları override etmek zorundadır. 
// Request Response patterni olduğu için her metod farklı sınıftan oluşturulmuş 
// nesneler ile doldurulması gerekiyor. 