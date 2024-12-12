package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.CriancaModel;

public interface CriancaRepository extends JpaRepository<CriancaModel, Long> { // Define a interface BolaRepository, que estende JpaRepository
    // JpaRepository oferece todos os métodos básicos como save(), findById(), delete(), etc., para a entidade BolaModel e sua chave primária Long {

}
