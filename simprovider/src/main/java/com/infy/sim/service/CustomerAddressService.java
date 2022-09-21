package com.infy.sim.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.sim.dto.CustomerAddressDTO;
import com.infy.sim.entity.CustomerAddress;
import com.infy.sim.repository.CustomerAddressRepository;

@Service
@Transactional
public class CustomerAddressService {

		@Autowired
		CustomerAddressRepository repo;
		public List<CustomerAddressDTO> getAllCustomerAddress(){
			List<CustomerAddress> customerAddress=repo.findAll();
			List<CustomerAddressDTO> customerAddressDTO=customerAddress.stream().map(i->i.convertEntityToDto(i)).toList();
			return customerAddressDTO;
		}
		
		public void addCustomerAddress(CustomerAddressDTO customerAddressDTO) {
			CustomerAddress customerAddress=customerAddressDTO.convertDtoToEntity(customerAddressDTO);
			repo.save(customerAddress);
		}
		
		/*Update Customer Address: Assuming that while purchasing the SIM, communication address has been submitted. 
		 * Now customer should be able to update the address if required for further communication.
		 */
		public CustomerAddressDTO updateCustomerAddress(Integer addressId,String address,String city,Integer pincode,String state) {
			Optional<CustomerAddress> customerAddress=repo.findById(addressId);
			if(customerAddress.isPresent()) {
				CustomerAddress custAddr=customerAddress.get();
				if(!custAddr.getAddress().equals(address)) {
					custAddr.setAddress(address);
				}
				if(!custAddr.getCity().equals(city)) {
					custAddr.setCity(city);
				}
				if(!custAddr.getPincode().equals(pincode)) {
					custAddr.setPincode(pincode);
				}
				if(!custAddr.getState().equals(state)) {
					custAddr.setState(state);
				}
				CustomerAddressDTO customerAddressDTO=custAddr.convertEntityToDto(custAddr);
				return customerAddressDTO;
			}
			CustomerAddress newCustomerAddress=new CustomerAddress();
			newCustomerAddress.setAddress(address);
			newCustomerAddress.setCity(city);
			newCustomerAddress.setPincode(pincode);
			newCustomerAddress.setState(state);
			repo.save(newCustomerAddress);
			return newCustomerAddress.convertEntityToDto(newCustomerAddress);
		}
}
