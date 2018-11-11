<?php 
    class User_model extends CI_Model {
        
        function get_user_album($user_id){
            return $this->db->query("SELECT a.* FROM album AS a, user AS u WHERE a.album_user_id='".$user_id."' ")->result_array();
        }

       

    }
?>
