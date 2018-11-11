<?php 
    class Data_model extends CI_Model {
        
        function get_table_information(){
            return $this->db->query("SELECT * FROM message")->result_array();
        }

        function get_album_name($album_id){
            return $this->db->query("SELECT photo_url FROM album, photograph WHERE photo_id='".$album_id."' ")->result_array();
        }

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

        function get_album_photo($photo_id){
            return $this->db->query("SELECT a.* FROM photograph AS a, user AS u WHERE a.album_id='".$photo_id."' ")->result_array();
        }


        function get_all_photos($album_id){
            return $this->db->query("SELECT a.* FROM photograph AS a WHERE a.album_id='".$album_id."' ")->result_array();
        }

        function get_photo_byId($photo_id){
            return $this->db->query("SELECT FROM photograph AS a WHERE a.photo_id='".$photo_id."'")->result_array();
        }

        function get_photo_byKeyword($key){
            return $this->db->query("SELECT p.photo_url FROM photograph AS p, keyword AS k WHERE k.key='".$key."' AND k.keyword_photo_id=p.photo_id  ")->result_array();
        }

        function get_photo_byUrl($url){
            return $this->db->query("SELECT FROM photograph AS a WHERE a.photo_url='".$url."'")->result_array();
        }

        function get_one_photo($album_id) {
            return $this->db->query("SELECT p.photo_url FROM photograph AS p WHERE p.album_id='".$album_id."' LIMIT 1")->result_array();
        }

    }
?>
