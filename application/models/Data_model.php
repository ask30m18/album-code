<?php 
    class Data_model extends CI_Model {
        
        function get_table_information(){
            return $this->db->query("SELECT * FROM message")->result_array();
        }

       

    }
?>
