package com.demoProject.notificationsreplica.model;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class GetNotificationsResponse {

	    private List<ActiveNotificationDB> docs = null;

	    private Integer total = null;

	    private Pageable pageable;

	    private Integer totalPages;

	    private Long totalElements;

	    public List<ActiveNotificationDB> getDocs() {
			return docs;
		}

		public void setDocs(List<ActiveNotificationDB> docs) {
			this.docs = docs;
		}

		public Integer getTotal() {
			return total;
		}

		public void setTotal(Integer total) {
			this.total = total;
		}

		public Pageable getPageable() {
			return pageable;
		}

		public void setPageable(Pageable pageable) {
			this.pageable = pageable;
		}

		public Integer getTotalPages() {
			return totalPages;
		}

		public void setTotalPages(Integer totalPages) {
			this.totalPages = totalPages;
		}

		public Long getTotalElements() {
			return totalElements;
		}

		public void setTotalElements(Long totalElements) {
			this.totalElements = totalElements;
		}

		public Boolean getLast() {
			return last;
		}

		public void setLast(Boolean last) {
			this.last = last;
		}

		private Boolean last;
	
}
