<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User extends CI_Controller {


	public function index()
	{
	    $this->load->model('User_model');

	    $data["album"]=$this->User_model->get_user_album(1);

		$this->load->view('login',$data);
	}
}
