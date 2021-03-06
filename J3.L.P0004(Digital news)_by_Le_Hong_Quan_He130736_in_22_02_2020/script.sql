USE [master]
GO
/****** Object:  Database [DigitalNews]    Script Date: 2/21/2020 2:41:04 PM ******/
CREATE DATABASE [DigitalNews]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DigitalNews', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DigitalNews.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DigitalNews_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DigitalNews_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DigitalNews] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DigitalNews].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DigitalNews] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DigitalNews] SET ARITHABORT OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DigitalNews] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DigitalNews] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DigitalNews] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DigitalNews] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DigitalNews] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DigitalNews] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DigitalNews] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DigitalNews] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DigitalNews] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DigitalNews] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DigitalNews] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DigitalNews] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DigitalNews] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DigitalNews] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DigitalNews] SET RECOVERY FULL 
GO
ALTER DATABASE [DigitalNews] SET  MULTI_USER 
GO
ALTER DATABASE [DigitalNews] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DigitalNews] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DigitalNews] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DigitalNews] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [DigitalNews] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DigitalNews', N'ON'
GO
USE [DigitalNews]
GO
/****** Object:  Table [dbo].[News]    Script Date: 2/21/2020 2:41:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](200) NULL,
	[description] [text] NULL,
	[author] [nvarchar](100) NULL,
	[date] [datetime] NULL,
	[image] [nvarchar](20) NULL,
 CONSTRAINT [PK_News] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[News] ON 

INSERT [dbo].[News] ([id], [title], [description], [author], [date], [image]) VALUES (1, N'Making security feeds smarter via machine learning', N'In today age of surverliance, with cameras even in our homes, security professionals need to monitor 
                        In today age of surverliance, with cameras even in our homes, security professionals need to monitor 
                        In today age of surverliance, with cameras even in our homes, security professionals need to monitor 
                        In today age of surverliance, with cameras even in our homes, security professionals need to monitor 
                        In today age of surverliance, with cameras even in our homes, security professionals need to monitor 
                        In today age of surverliance, with cameras even in our homes, security professionals need to monitor
                        In today age of surverliance, with cameras even in our homes, security professionals need to monitor', N'Benjamin Cher', CAST(N'2016-04-12 02:29:00.000' AS DateTime), N'i1.jpg')
INSERT [dbo].[News] ([id], [title], [description], [author], [date], [image]) VALUES (2, N'In today age of surverliance', N'In today age of surverliance, with cameras even in our homes, security professionals need to monitor In today age of surverliance, with cameras even in our homes, security professionals need to monitor', N'Quan Le Hong', CAST(N'2016-05-12 02:29:00.000' AS DateTime), N'i1.jpg')
INSERT [dbo].[News] ([id], [title], [description], [author], [date], [image]) VALUES (3, N'Writing for His Country', N'This was the beginning of a speech by Mario Vargas Llosa. He gave this speech after receiving the Nobel Prize for Literature. Today''s Spotlight is on this Peruvian writer, politician, and reporter. Vargas Llosa is one of the most important writers from Latin America. He spent most of his life writing about the struggles of normal people against oppression. He even ran for president of Peru. But his writing and ideas have been controversial. Many people disagree with him. But his writing has brought the world''s attention to Peru.', N'Benjamin Cher', CAST(N'2016-04-13 02:29:00.000' AS DateTime), N'i1.jpg')
INSERT [dbo].[News] ([id], [title], [description], [author], [date], [image]) VALUES (4, N'More than a Football Game', N'On March 11th, 2011, Japan suffered a major earthquake and tsunami. This large wave of water crashed onto the northern coast of Japan. The earthquake and tsunami killed over 15,000 people and injured thousands more.  The events destroyed many buildings and villages. The tsunami also caused major accidents at three building that produce nuclear power. Hundreds of thousands of people were forced to leave their homes to seek safety. These events caused much pain and suffering for the people of Japan.', N'Quan Le Hong', CAST(N'2016-04-14 02:29:00.000' AS DateTime), N'i1.jpg')
INSERT [dbo].[News] ([id], [title], [description], [author], [date], [image]) VALUES (5, N'Collecting Sneakers', N'What are on your feet right now? Are you wearing shoes? What kind are you wearing? People have many opinions about shoes. Many people think that shoes should protect our feet. Shoes should feel good to wear. Shoes should be made to last a long time. Other people think that shoes do much more than this. They believe that shoes tell the world who we are.', N'Benjamin Cher', CAST(N'2016-04-15 02:29:00.000' AS DateTime), N'i1.jpg')
INSERT [dbo].[News] ([id], [title], [description], [author], [date], [image]) VALUES (6, N'The Joy of Christmas Music', N'There is a kind of song that Paul McCartney and Justin Bieber sing. Whitney Houston, Taylor Swift, Elton John, Run DMC, Bob Dylan, Michael Jackson, Lady Gaga, The Beach Boys and Stevie Wonder all sing this kind of song too. It is a special kind of music for a special time of year. It is Christmas music! Today’s Spotlight is on English Christmas songs.', N'Benjamin Cher', CAST(N'2016-04-17 02:29:00.000' AS DateTime), N'i1.jpg')
SET IDENTITY_INSERT [dbo].[News] OFF
USE [master]
GO
ALTER DATABASE [DigitalNews] SET  READ_WRITE 
GO
