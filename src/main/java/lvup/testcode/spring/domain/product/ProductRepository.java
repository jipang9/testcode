package lvup.testcode.spring.domain.product;

import java.util.List;
import lvup.testcode.spring.domain.product.enums.ProductSellingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingTypes);

  List<Product> findByProductNumberIn(List<String> productNumbers);
}
