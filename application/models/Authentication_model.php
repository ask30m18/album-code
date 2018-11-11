<?php 
    class Authentication_model extends CI_Model {
        
        function get_pass($id){
            return $this->db->query("SELECT password FROM user WHERE user_id = '".$id."'")->row(0,"array");
        }

    }
?>
