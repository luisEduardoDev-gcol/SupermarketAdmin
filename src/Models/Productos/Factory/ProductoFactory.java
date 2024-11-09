/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models.Productos.Factory;

/**
 *
 * @author Simón David Cruz S
 */
public interface ProductoFactory {
    
    public Bebidas crearBebidas();
    
    public Congelados crearCongelados();
    
    public Farmaceuticos crearFarmaceuticos();
    
    public Higiene_y_Limpieza crearHigiene_y_Limpieza();
    
    public Mascotas crearMascotas();
    
    public Panaderia_y_Pasteleria crearPanaderia_y_Pasteleria();
}
