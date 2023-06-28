package com.lucaslearning.dslearnbds.observers;

import com.lucaslearning.dslearnbds.entities.Deliver;

public interface DeliverRevisionObserver {
	
	void onSaveRevision(Deliver deliver);
	
}
