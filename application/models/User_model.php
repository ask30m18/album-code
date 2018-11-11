<?php
class User_model extends CI_Model {

    function get_user_album($user_id){
        return $this->db->query("SELECT a.* FROM album AS a, user AS u WHERE a.album_user_id='".$user_id."' ")->result_array();
    }

    function get_all_users(){
        return $this->db->query("SELECT * FROM user")->result_array();
    }

    function get_user_byId($user_id){
        return $this->db->query("SELECT FROM user AS a WHERE a.user_id='".$user_id."'")->result_array();
    }

    function get_user_byUserName($user_name){
        return $this->db->query("SELECT FROM user AS a WHERE a.user_name='".$user_name."'")->result_array();
    }

    function get_user_byName($name){
        return $this->db->query("SELECT FROM user AS a WHERE a.name='".$name."'")->result_array();
    }
    
}
?>