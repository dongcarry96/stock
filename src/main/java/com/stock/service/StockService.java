package com.stock.service;

import com.stock.domain.Stock;
import com.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository stockRepository;

    // 생성자 생성
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    // 재고감소 메소드
//    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        // Stock 조회
        // 재고를 감소시킨뒤
        // 갱신된 값을 저장하도록
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }


}
