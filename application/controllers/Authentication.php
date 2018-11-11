<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Authentication extends CI_Controller {

	public function index()
	{
		$d = $this->input->post();
		var_dump($d);
		die();
	    $this->load->model('Authentication_model');

	    $data=$this->Authentication_model->get_pass($username);

	    if($data == $id) {
	    	$this->load->view('user_detail');
	    } else {
	    	$this->load->view('login');
	    }


		
	}
}
