
<?php 
    class Album_model extends CI_Model {
        
        function get_album_id($album_user_id){
            return $this->db->query("SELECT album_id FROM album WHERE album_id='".$album_user_id."' ")->result_array();
        }

		function get_album_name($album_id){
            return $this->db->query("SELECT photo_url FROM album, photograph WHERE photo_id='".$album_id."' ")->result_array();
        }      
    }
?>
