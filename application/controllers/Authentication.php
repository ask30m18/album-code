<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Authentication extends CI_Controller {

	public function index($id,$pass)
	{
	    $this->load->model('Authentication_model');

	    $data=$this->Authentication_model->get_pass($id);

	    if($data == $id) {
	    	$this->load->view('main');
	    } else {
	    	$this->load->view('main');
	    }


		
	}
}
