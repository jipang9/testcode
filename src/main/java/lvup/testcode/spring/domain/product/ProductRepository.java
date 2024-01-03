package lvup.testcode.spring.domain.product;

import java.util.List;
import lvup.testcode.spring.domain.product.enums.ProductsellingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllBySellingStatusIn(List<ProductsellingStatus> sellingTypes);
}
