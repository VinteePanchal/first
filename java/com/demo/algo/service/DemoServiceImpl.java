package com.demo.algo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.algo.model.DemoTable;
import com.demo.algo.repository.DemoRepository;

@Component("demoService")
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoRepository demoRepository;
	
	public DemoServiceImpl(DemoRepository demoRepository) {
		this.demoRepository = demoRepository;
	}

	@Override
	public List<DemoTable> getData() {
		return demoRepository.getData();
	}

	@Override
	public DemoTable saveData(List<Integer> unsortedList) {
		DemoTable demoTable = new DemoTable();
		Long Id = demoRepository.getMaxId();
		if(null == Id){
			Id = 1L;
		}
		demoTable.setId(Id + 1);
		demoTable.setUnsorted(unsortedList.toString());

		int n = unsortedList.size();
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if(unsortedList.get(j+1).compareTo(unsortedList.get(j)) < 0) {
					unsortedList.add(j, unsortedList.remove(j+1));
	            }
		
		demoTable.setSorted(unsortedList.toString());

		return demoRepository.save(demoTable);
	}

}
