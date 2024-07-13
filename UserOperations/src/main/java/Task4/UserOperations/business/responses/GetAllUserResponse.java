package Task4.UserOperations.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok notasyonları ile sınıf yapılarını tanımladım 
// Bu sınıf getall isteğine döndürülecek nesnenin hangi
// özellikleri gösterileceğini tanımlamak için kullanıldı.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {
	private int id;
	private String name;
	private String email;
}
