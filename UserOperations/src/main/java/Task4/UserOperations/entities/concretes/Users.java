package Task4.UserOperations.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users") // database içerisinde users tablosu oluşması ve özellikleri bu sınıftan alması
						// için
@Data // lombok eklentisi ile sınıf yapılarını kolayca oluşturma
@AllArgsConstructor // lombok eklentisi ile sınıf yapılarını kolayca oluşturma
@NoArgsConstructor // lombok eklentisi ile sınıf yapılarını kolayca oluşturma
@Entity // bu sınıfın bir varlık olduğunu belirtmek için
public class Users {

	// ID değerinin bir key olduğunu belirtiyoruz. Database üzerinde bir kolon
	// olarak bulunacak
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id'nin otomatik olarak artması için
	@Column(name = "id")
	private int id;

	// Database üzerinde name kolonunu bu değerden alacağını belirtmek için
	@Column(name = "name")
	private String name;

	// Database üzerinde email kolonuna eşler.
	@Column(name = "email")
	private String email;

}
