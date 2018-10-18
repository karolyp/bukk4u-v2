package hu.rendszerfejlesztes.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.rendszerfejlesztes.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
