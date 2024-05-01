package com.yu.rental.dao;

import com.yu.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    /**
     * 因繼承 JpaRepository，所以不需要實作任何方法，即可使用「新增、修改、刪除」等基本功能。
     * 注意：JpaRepository的泛型為 <T,ID>，所以在使用繼承時，必須定義好 T 與 ID 的型別，也就是 <MemberDTO, Long>。
     */
    @Transactional
    public Rental findByrNo(Integer rNo);

    @Transactional
    public Rental findByrName(String rName);
}