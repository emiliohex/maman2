package techflix;

import techflix.business.Movie;
import techflix.business.MovieRating;
import techflix.business.ReturnValue;
import techflix.business.Viewer;
import techflix.data.DBConnector;
import techflix.data.PostgresSQLErrorCodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        //createTables();
        Movie movieOne=new Movie();
        movieOne.setId(1);
        movieOne.setName("BOB");
        movieOne.setDescription("Action Movie");
        createMovie(movieOne);
    }

    public static void createTables() {
        Connection connection = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        try {

            pstmt = connection.prepareStatement("CREATE TABLE Viewers\n" +
                    "(\n" +
                    "    ViewerID integer ,\n" +
                    "    Name varchar(255) NOT NULL,\n" +
                    "    PRIMARY KEY (ViewerID),\n" +
                    "    CHECK (ViewerID >0)\n" +
                    ");" +
                    "CREATE TABLE Movies\n" +
                    "(\n" +
                    "MovieID integer,\n" +
                    "Name varchar(255) NOT NULL,\n" +
                    "Description text NOT NULL, \n" +
                    "PRIMARY KEY (MovieID), \n" +
                    "CHECK (MovieID>0) \n" +
                    ");" +
                    "CREATE TABLE Watched\n" +
                    "(\n" +
                    "ViewerID integer,\n" +
                    "MovieID integer,\n" +
                    "Rating varchar(7) CHECK(Rating IN('LIKE', 'DISLIKE', 'NONE'))\n" +
                    ")"
            );
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public static void clearTables() {

    }


    public static void dropTables() {

    }


    public static ReturnValue createViewer(Viewer viewer) {

        return null;
    }

    public static ReturnValue deleteViewer(Viewer viewer) {

        return null;
    }

    public static ReturnValue updateViewer(Viewer viewer) {

        return null;
    }

    public static Viewer getViewer(Integer viewerId) {

        return null;
    }


    public static ReturnValue createMovie(Movie movie) {

        Connection connection = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        try {

            pstmt = connection.prepareStatement("INSERT INTO Movies(" +
                    " MovieID,Name,Description)" +
                    "(\n" +
                    "VALUES (" + Integer.toString(movie.getId()) +",'"+ movie.getName()+"','" +
                            movie.getDescription()+"');"
            );
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    public static ReturnValue deleteMovie(Movie movie) {

        Connection connection = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        try {

            pstmt = connection.prepareStatement("DELETE FROM Movies" +
                    "(\n" +
                    "Where Movies.MovieID=" + Integer.toString(movie.getId())+ ");"
            );
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    public static ReturnValue updateMovie(Movie movie) {
        Connection connection = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        try {

            pstmt = connection.prepareStatement("UPDATE Movies" +
                    "(\n" +
                    "SET Movies.Description='" + movie.getDescription() + "');"
            );
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    public static Movie getMovie(Integer movieId) {

        return null;
    }


    public static ReturnValue addView(Integer viewerId, Integer movieId) {

        return null;
    }

    public static ReturnValue removeView(Integer viewerId, Integer movieId) {

        return null;
    }

    public static Integer getMovieViewCount(Integer movieId) {

        return null;
    }


    public static ReturnValue addMovieRating(Integer viewerId, Integer movieId, MovieRating rating) {

        return null;
    }

    public static ReturnValue removeMovieRating(Integer viewerId, Integer movieId) {

        return null;
    }

    public static int getMovieLikesCount(int movieId) {

        return -1;
    }

    public static int getMovieDislikesCount(int movieId) {

        return -1;
    }

    public static ArrayList<Integer> getSimilarViewers(Integer viewerId) {

        return null;
    }


    public static ArrayList<Integer> mostInfluencingViewers() {

        return null;
    }


    public static ArrayList<Integer> getMoviesRecommendations(Integer viewerId) {

        return null;
    }


    public static ArrayList<Integer> getConditionalRecommendations(Integer viewerId, int movieId) {

        return null;
    }

}


