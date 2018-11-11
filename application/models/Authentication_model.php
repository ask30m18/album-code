<?php 
    class Authentication_model extends CI_Model {
        
        function get_pass($username){
            return $this->db->query("SELECT password FROM user WHERE user_name = '".$username."'")->row(0,"array");
        }

    }
?>
